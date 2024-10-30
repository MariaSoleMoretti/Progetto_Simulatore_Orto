# Progetto_PMO
Il progetto simula la gestione di un orto privato. Si potra coltivare, monitorare e raccogliere piante, il tutto gestito tramite interfaccia grafica.

## Design del progetto
### Scompartimento
- Lo spazio disponibile è suddiviso in scompartimenti, di defaul ne viene già instanziato uno, gli altri possono essere aggiunti a piacimento dall'utente, fino ad un massimo di 4.
- Ad ogni scompartimento viene associato un Sensore Umidità che si occupa di simulare il diminure dell'umidità del terreno e notifica quando bisogna innaffiare.
- Per ogni scompartimento verrà indicato il valore di umidità del terreno, e verrà notificato tramite GUI quando sarà neccessario innafiare.
### Pianta
- In ogni scompartimento si possono aggiungere massimi 4 piante tra:
  - Pomodoro;
  - Cipolla;
  - Insalata;
  - Carota.
- Ogni tipologia di pianta ha la propria velocità di crescita ed un valore minimo di umidità del suolo necessaria per la crescita.
- Il ciclo di vita delle piante progredisce alternandosi nei seguenti stati
  - Germinazione >> Fioritura >> Maturazione >> Senescenza
- Le piante potranno essere raccolte solo se nello stato di Senescenza, ed avranno un rendimento di 4 ortaggi.
