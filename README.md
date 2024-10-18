# Leilão Test Automation

Este repositório contém um projeto de automação de testes utilizando **Selenium**, com o objetivo de testar uma aplicação web chamada **Leilão**, que está rodando localmente em **http://localhost:8080**.

---

## 📁 Estrutura do Projeto

O projeto já possui uma aplicação pronta e configurada para darmos andamento aos testes automatizados. A automação foi implementada utilizando a biblioteca Selenium, garantindo uma cobertura eficiente de funcionalidades web.


----
login da aplicacao: http://localhost:8080/login

---

## 🚀 Como Executar

1. **Pré-requisitos:**
    - Certifique-se de ter o **Java 17** instalado.
    - Instale um navegador compatível (ex.: Chrome ou Firefox).
    - Adicione o **WebDriver** correspondente ao navegador no **PATH** do sistema (ex.: chromedriver para Chrome).

2. **Clone o repositório:**
   ```bash
   git clone https://github.com/emersoncamilo/selenium.git
   ```  
3. **Acesse o diretório do projeto:**
   ```bash
   cd selenium
   ```  

4. **Verifique se a aplicação está rodando em localhost:**  
   A aplicação **Leilão** precisa estar ativa em **http://localhost:8080**.
    - Se ainda não estiver em execução, inicialize-a no ambiente local para garantir que os testes possam ser executados corretamente.

5. **Execute os testes:**  
   Compile e execute os testes usando Maven ou Gradle.

   **Com Maven:**
   ```bash
   mvn clean test
   ```  

   **Com Gradle:**
   ```bash
   gradle clean test
   ```  

---

## 🧪 Bibliotecas e Ferramentas Utilizadas

- **Selenium WebDriver**: Para automação dos testes em navegadores.
- **JUnit**: Estrutura de testes automatizados.
- **Maven/Gradle**: Para gerenciamento de dependências e execução dos testes.

---

## 📋 Próximos Passos

- Adicionar mais casos de teste para aumentar a cobertura.
- Configurar **relatórios de teste** automatizados.
- Implementar integração contínua (CI) para rodar testes automaticamente em cada push.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Selenium WebDriver**
- **JUnit**
- **Maven/Gradle**

---

## 🤝 Contribuição

Contribuições são bem-vindas! Caso encontre problemas ou tenha sugestões, sinta-se à vontade para abrir uma **issue** ou enviar um **pull request**.

---

## 📢 Contato

Se quiser conversar sobre este projeto ou outras oportunidades, você pode me encontrar no [LinkedIn](https://www.linkedin.com/in/ecamiloit/).

---