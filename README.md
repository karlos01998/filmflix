# FilmFlix 🎬

# FilmFlix 🎬

Uma aplicação backend desenvolvida em Java focada no catálogo, gerenciamento e avaliação de filmes. Este projeto foi construído para consolidar conceitos fundamentais de Programação Orientada a Objetos (POO) e arquitetura de software.

---

## 📌 Sobre o Projeto

O **FilmFlix** é um sistema interativo via console que permite gerenciar fichas técnicas de filmes e realizar avaliações numéricas personalizadas.

A aplicação foi projetada pensando em escalabilidade e organização estrutural, mitigando o acúmulo de responsabilidades e aplicando boas práticas de desenvolvimento backend através da divisão clara de componentes.

## 🏗️ Arquitetura e Padrões de Projeto

O sistema foi inteiramente estruturado utilizando o padrão arquitetural **MVC (Model-View-Controller)**, dividindo as responsabilidades do software de forma clara:

* **Model (`FilmeModel`)**: Camada responsável por encapsular os dados e regras de negócio da entidade Filme (atributos como título, ano de lançamento, duração e notas recebidas).
* **View (`FilmeView`)**: Camada de interface com o usuário, controlando estritamente as entradas (`Scanner`) e saídas (`System.out.println`) via console, cuidando da formatação dos menus de exibição.
* **Controller (`FilmeController`)**: Camada mediadora que recebe as ações da View, gerencia a lógica de fluxo de dados (como as coleções em memória) e atualiza o Model.

## 🚀 Funcionalidades

* [x] **Catálogo de Filmes:** Inicialização do sistema com um ecossistema pré-definido de títulos (*Interestelar, Ilha do Medo, A Origem*, etc.).
* [x] **Interface Interativa:** Menu dinâmico via terminal para navegação fluida e escolha de opções.
* [x] **Ficha Técnica Detalhada:** Exibição estruturada contendo título, ano, duração formatada e métricas de visualizações.
* [x] **Sistema de Avaliação Direta:** Atribuição de notas de 0 a 10 para cada título cadastrado e cálculo das médias de visualização.
* [x] **Distribuição Nativa:** Compilação e empacotamento em um executável autônomo para ambiente Windows (`.exe`).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17/21)
* **IDE:** IntelliJ IDEA
* **Encoding:** UTF-8 para padronização de acentuação e textos no terminal.
* **Deployment:** Launch4j (conversão de artefato `.jar` para `.exe` executável em modo Console).

## 🎮 Como Executar a Aplicação

### Via IDE (Código Fonte)
1. Clone o repositório:
   ```bash
   git clone [https://github.com/karlos01998/filmflix.git](https://github.com/karlos01998/filmflix.git)