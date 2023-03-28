#![no_std]
#![no_main]

use core::arch::asm;
use core::panic::PanicInfo;
use core::ptr::write_volatile;

#[no_mangle]
pub extern "C" fn _start() -> ! {
    unsafe {
        asm!(
            ".syntax unified",
            ".cpu cortex-m3",
            ".thumb",
            ".word 0x20000400",
            ".word 0x080000ed",
            ".space 0xe4",
            "ldr r1, =0x40023800",
            "ldr r0, =0x00008007",
            "str r0, [r1, #0x1C]",

            "ldr r1, =0x40020000",
            "ldr r0, =0xA8000400",
            "str r0, [r1, #0x00]",

            "ldr r0, =0x20",
            "ldr r1, =0x40020000",
            "str r0, [r1, #0x14]"
        );
        /*{
            write_volatile(0x4002381C as *mut u32, 0x00008007);
            write_volatile(0x40020000 as *mut u32, 0xA8000400); // Turn into output
        }*/
        loop {
            write_volatile((0x4002_0014 as *mut u32), 0x0);
        }
    }
}

#[panic_handler]
fn panic(_info: &PanicInfo) -> ! {
    loop {}
}