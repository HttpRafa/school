cd asm/
arm-none-eabi-as -g main.s -o main.o
arm-none-eabi-ld main.o -o main.elf -Ttext=0x8000000
arm-none-eabi-objdump -d main.elf
/home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/bin/openocd -f /home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/openocd/scripts/interface/stlink.cfg -f /home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/openocd/scripts/target/stm32l1.cfg -c "program main.elf verify reset exit"
