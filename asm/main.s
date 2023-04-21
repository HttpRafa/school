.include "startup.s"

ldr r1, =0x40020000 // Port A 
ldr r0, =0xA8005400 // PinA5 - 7
str r0, [r1, #0x00] // Write to address

ldr r1, =0x40020400 // Port B 
ldr r0, =0xA8001000 // PinB6
str r0, [r1, #0x00] // Write to address

main:
  ldr r3, =0xFFFF // time to stay on and wait
  ldr r2, =0x40020000 // Port A
  ldr r1, =0xE0 // PinA5 - 7 off
  ldr r0, =0xC0 // PinA5 on
  bl blink

  bl wait

  ldr r0, =0xA0 // PinA6
  bl blink

  bl wait

  ldr r0, =0x60 // PinA7
  bl blink

  bl wait

  ldr r2, =0x40020400 // Port B
  ldr r1, =0x40 // PinB6 off
  ldr r0, =0x00 // PinB6 on
  bl blink

  bl wait

b main // Loop

blink: // r0 on led values | r1 off led values | r2 port address | r3 time to stay on
  push {r14, r0}
  str r0, [r2, #0x14] // Write r0 into base address with offset 0x14 | On
    
  mov r0, r3 // Copy r3 to r0
  bl wait

  str r1, [r2, #0x14] // Write r0 into base address with offset 0x14 | Off
  pop {r0, r14}
  bx r14

wait: // r0 value to wait
  push {r5}
  mov r5, #0 // Current value preperations
  for_0: // Label for_0
    cmp r0, r5 // Compare current value to target value
    add r5, r5, #1 // Add 1 to current value
    bne for_0 // Jump to address if for_0
  pop {r5}
  bx r14 // Jump to address stored in link register

