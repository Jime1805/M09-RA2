# 06-Espera_wait

## Preguntes Teòriques

### 1. Per què s’atura l’execució al cap d’un temps?

L'execució aparantment s'atura perque tots els asistents poden quedar esperant quan no hi ha places disponibles.
Si no hi ha cap cancel·lació, ningú fa un "notifyAll()" i el fils queden bloquejats.


### 2. Canvi de probabilitats

#### a. 70% ferReserva - 30% cancelaReserva

En la clase Assistent hem de canviar el codi per aquest:

@Override
public void run(){
    while (true) {
        if (random.nextInt(100) < 70) {
            esdeveniment.ferReserva(this);
        }
        else{
            esdeveniment.cancelaReserva(this);
        }

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
            break;
        }
    }
}

Sortida:

![alt text](<Captura de pantalla 2026-01-29 192743-1-1.png>)

Efectes:
    - Les places s'omplen molt més rapid
    - Molts fils queden en espera
    - El programa sembla bloquejar-se més sovint

#### b. 30% ferReserva - 70% cancelaReserva

@Override
public void run(){
    while (true) {
        if (random.nextInt(100) < 30) {
            esdeveniment.ferReserva(this);
        }
        else{
            esdeveniment.cancelaReserva(this);
        }

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (Exception e) {
            break;
        }
    }
}

Sortida: 

![alt text](<Captura de pantalla 2026-01-29 194155.png>)

Efectes:
    - Moltes cancel·lacions innecessaries
    - Les places rarament arriben a 0
    - El sistema continua actiu durant més temps

### 3. Per què cal la llista i no només un enter

La llista permet saber qui ha fet la reserva. Si només tingèssim un enter de places, no podriem.
També ens permet evitar que un assistent cancel·li una reserva que no en té, a més de saber quins assistents han reservat.

Això garanteix la consistència i coherència del sistema.