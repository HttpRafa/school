//############ Startup ##########################################
 .syntax unified			//Sprachtyp
 .cpu cortex-m3				//Chip
 .thumb						//Befehlssatz

 //####################### Vektor-Tabelle #######################
 .word 0x20000400			//Anfang Stackpionter -> SP
 .word 0x080000ed			//reset_handler: Programmadresse nach reset
 .space 0xe4				//Reservierter Platz für Interrupt-Vektoren

.include "reg.s"

 .global _start				//für Linker wichtig: Definition, an welcher Adresse das Programm anfängt
 _start:	
 
  	ldr r1, =RCC		    //GPIOA,B,C aktivieren (7:...111)
	ldr r0, =0x00008007		//
	str r0, [r1,AHBENR]		
