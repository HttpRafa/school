.include "startup.s"

ldr r1, =0x40020000 // Port A 
ldr r0, =0xA8005400 // Pin5 - 7
str r0, [r1, #0x00] // Write to address

ldr r1, =0x40020400 // Port B
//ldr r0, =0xA8000400 // 
ldr r0, =0xA8010000 // Pin8
str r0, [r1, #0x00] // Write to address

main:
  ldr r2, =0xFFFF // time to stay on and wait
  ldr r1, =0x40020000 // Port A
  ldr r0, =0x20 // Pin5
  bl blink

  bl wait

  ldr r0, =0x40 // Pin6
  bl blink

  bl wait

  ldr r0, =0x80 // Pin7
  bl blink

  bl wait

  ldr r1, =0x40020400 // Port B
  ldr r0, =0x100 // Pin8
  bl blink

  bl wait

b main // Loop

blink: // r0-> led values | r1 port address | r2 time to stay on
  str r0, [r1, #0x14] // Write r0 into base address with offset 0x14 | On
  mov r0, r2 // Copy r2 to r0
  bl wait // Execute wait
  mov r0, #0 // Overwrite r0 with 0 | Off
  str r0, [r1, #0x14] // Write r0 into base address with offset 0x14 | Off
  bx r14

wait: // r0 value to wait | r5->
  mov r5, #0 // Current value preperations
  for_0: // Label for_0
    cmp r0, r5 // Compare current value to target value
    add r5, r5, #1 // Add 1 to current value
    bne for_0 // Jump to address if for_0
  bx r14 // Jump to address stored in link register

