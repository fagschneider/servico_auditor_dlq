  A arquitetura Hexagonal foi escolhida porque ela permite separar melhor a regra de negócio das partes externas da aplicação, como AWS SQS e banco de dados.
Isso deixa o projeto mais organizado, mais fácil de manter e facilita futuras mudanças de tecnologia sem mexer na lógica principal do sistema.
  Além disso, escolhi essa arquitetura porque já tenho mais afinidade com o padrão Hexagonal devido a atividade anteriore. Isso ajudou
no desenvolvimento do projeto, tornando mais simples organizar as responsabilidades de cada camada e manter uma estrutura mais limpa e desacoplada.
  As pastas foram organizadas seguindo a ideia da Arquitetura Hexagonal, separando cada responsabilidade da aplicação em uma camada específica.
A pasta core concentra as regras de negócio e os modelos principais do sistema. Na pasta application ficou os casos de uso e as portas de entrada e saída,
coordenando o fluxo da aplicação sem depender diretamente de tecnologias externas.
  Já a pasta infrastructure reúne tudo que se comunica com recursos externos, como AWS SQS, banco de dados e configurações do Spring. 
Dessa forma, o projeto fica mais organizado, desacoplado e fácil de manter, além de facilitar futuras alterações sem impactar a lógica principal do sistema.
