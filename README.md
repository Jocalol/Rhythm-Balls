# RhythmBalls

Projeto realizado no âmbito da UC DJPM do curso Licenssiatura em Engenharia em Desenvolvimento de Jogos Digitais


## Membros 

Francisco Gomes - 27941
Jorge Costa - 27923
Maria Costa - 22530


## Descrição do jogo

**RhythmBalls** é um jogo usando como base **Kotlin**.

Este jogo usou como inspiração titulos como "**Osu!**" e "**Guitar Hero**"; Poderá ser jogado por duas pessoas, havendo a opção de usar __<ins>Teclado</ins>__ ou __<ins>Comando</ins>__ como input, em que o objetivo é derrotar o adversário através de ataques corpo-a-corpo até o HP chegar no valor **0**. Ambos os players estarão confinados a uma arena de pedra, sem possibilidade de abandonar a mesma.


## Plataformas

RhythmBalls é apenas jogável em Android.

# Estrutura e Organização do Código

Os ficheiros `.kt` deste projeto não apresentam qualquer tipo de organização por pastas, encontrando-se todos no interior da pasta principal da aplicação. Este projeto usa também *Model View ViewModel ( MVVM )* como modelo de prgramação.

 
## Funções
### LoginView.kt, LoginViewModel.kt, RegisterView.kt e RegisterViewModel.kt
RgisterView.kt e LoginView.kt são os 2 ficheiros responsáveis por toda a UI de Register e Login e onde é efetuada as chamadas às funções responsáveis por estas funcionalidades. Já os 2 restantes ficheiros, RegisterViewModel e LoginViewModel, é onde é efetuada a conexão da aplicação ao Firebase( backend ) e gerido os atributos necessários para realiar as funcionalidades de Login e Register.

### MenuScreen.kt
Neste ficheiro é onde é armazenado a criação do menu principal e todo o tipo de interações possíveis a partir deste. 

### SongNote.kt e WriteSong.kt
SongNote.kt tem como propósito guardar as propriedades das timestamps. WriteSong.kt através das propriedades guardadas em SongNote.kt cria um array com várias "*Notes*" de a  forma a guardar as várias *timestamps* da música.

### Ball.kt
Classe onde são guardadas todas as propriedades do circulo que o jogador irá interagir..

### GameView.kt
Este ficheiro é responsável pelo processamento do jogo.



# Considerações Finais
O jogo ainda pode ser aprimorado visto que ainda faltam algumas implementações básicas, como uma forma de guardar e mostrar "Scores". Foi tentada uma implementação deste mesmo sistema, no entanto nunca foi deixado funcional derivado a problemas com a thread principal do jogo.






