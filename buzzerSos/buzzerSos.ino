/*
 * @author Rafael K.
 * @since 18.09.2023
 */

#define BUZZER PB3                                  // Buzzer auf MFS
#define TASTER PA1                                  // Taster auf MFS

#define TIME_SHORT 200                              // Zeit die beim kurzen Signal genutzt wird
#define TIME_LONG 400                               // Zeit die beim langen Signal genutzt wird

void setup() {                                      // Einmalige Ausführung
  pinMode(BUZZER, OUTPUT);                          // BUZZER: Ausgang
  pinMode(TASTER, INPUT);                           // TASTER: Eingang

  digitalWrite(BUZZER, HIGH);                       // BUZZER: Aus
}

void loop() {                                       // Wiederholte Ausführung
  if(!digitalRead(TASTER)) playSound();             // Wenn der TASTER gedrückt wird playSound aufrufen
}

void playSound() {                                  // Funktion um denn SOS Sound abzuspielen
  play(TIME_SHORT);                                 // 3 mal einen Ton mit der Zeit TIME_SHORT abspielen
  play(TIME_LONG);                                  // 3 mal einen Ton mit der Zeit TIME_LONG abspielen
  play(TIME_SHORT);                                 // 3 mal einen Ton mit der Zeit TIME_SHORT abspielen
  delay(TIME_LONG * 4);                             // Warten um die Zeit 4 * TIME_LONG um spam zu vermeiden
}

void play(int time) {                               // Spielt einen Ton für n ms ab
  for(int i = 0; i < 3; i++) {                      // Wiederhole denn Code 3 mal
    digitalWrite(BUZZER, LOW);                      // BUZZER: Ein
    delay(time);                                    // Warten für time ms
    digitalWrite(BUZZER, HIGH);                     // BUZZER: Aus
    delay(time);                                    // Warten für time ms
  }
  delay(TIME_LONG);                                 // Am ende nochmal TIME_LONG ms warten
}
