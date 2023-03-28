#![no_std]
#![no_main]

use core::arch::asm;
use core::panic::PanicInfo;
use core::ptr::write_volatile;

#[no_mangle]
#[link_section = ".text._start"]
pub extern "C" fn _start() -> ! {
    let led_base: u32 = 0x40020000;
    let led_state = led_base | 0x14;

    unsafe {
        asm!(
        "ldr r1, =0x40023800",
        "ldr r0, =0x00008007",
        "str r0, [r1, #0x1C]", // Enable GPIO: A, B, C
        "ldr r1, =0x40020000",
        "ldr r0, =0xA8000400",
        "str r0, [r1, #0x00]", // Set LED as output
        /*"ldr r0, =0x20",
        "ldr r1, =0x40020000",
        "str r0, [r1, #0x14]"*/ // Turn LED on
        );

        loop {
            write_volatile(led_state as *mut u32, 1 << 5); // Turn LED on

            for _ in 0..65000 { // Wait
                asm!("nop");
            }

            write_volatile(led_state as *mut u32, 0x00); // Turn LED off

            for _ in 0..65000 { // Wait
                asm!("nop");
            }
        }
    }
}

#[panic_handler]
fn panic(_info: &PanicInfo) -> ! {
    loop {}
}