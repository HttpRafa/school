cargo rustc -- -C link-arg=--script=./linker.ld
cd target/armv7a-none-eabi/debug/
arm-none-eabi-objdump -d armrust
mv armrust main.elf
/home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/bin/openocd -f /home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/openocd/scripts/interface/stlink.cfg -f /home/rafael/Desktop/programs/xpack-openocd-0.12.0-1/openocd/scripts/target/stm32l1.cfg -c "program main.elf verify reset exit"
