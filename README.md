# RhythmBalls

Projeto realizado no âmbito da UC DJPM


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

### Input.cs
Como o próprio nome indica, esta classe é responsável pelo armazenameto das propriedades responsáveis pelo input do utilizador. Como já mencionado anteriormente, existe a possibilidade de utilizar Teclado e Comando como input.

### Map.cs
Classe responsável pela geração do mapa, certos objetos do mapa são gerados de forma aleatória. Após gerar os objetos de forma aleatória, é criado o fundo do mapa.

### Sprite.cs
Classe responsável pelo desenho das texturas dos objetos na tela.

### Player.cs e Player2.cs
Classes herdeiras de **Sprite.cs** responsáveis por colocar o Player no mapa, gere também as animações deste, bem como o próprio ataque acompanhado do som.

>[!Note]
> Estas classes responsáveis por ambos os players partilharam bastantes semelhanças, pelo que uma poderia ser herdeira da outra ou então encontrar-se as propriedades no interior da mesma classe.

# Considerações Finais
Apesar de o projeto encontra-se numa fase bastante primitiva, faltando várias implementações, como: Hitboxes, Menus e UI; trata-se de um projeto bastante interessante que poderá ser continuado o desenvolvimento num futuro muito próximo.






