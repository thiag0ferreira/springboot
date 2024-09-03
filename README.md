Projeto funcionando:

![Descrição do GIF](https://github.com/thiag0ferreira/springboot/blob/master/apis.gif)

Para o uso deste projeto é preciso ter o mySql e o Java instalados na máquina.
Siga os passos: 
1. Conecte-se ao MySQL; mysql -u root -p
2. Em seguida criar o scripty a baixo no seu sql:

CREATE DATABASE carros;
CREATE TABLE carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(255),
    descricao TEXT,
    url_foto VARCHAR(255),
    url_video VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255)
);

3. Modifique o aplication, arquivo do projeto, para as configurações do seu banco;
4. Por fim, rode para o mySql iniciar o servidor: sudo service mysql start.

Rodar o projeto
- mvn clean install
- mvn spring-boot:run

Acessando pelo link: * http://localhost:8080/swagger-ui.html#/carros45controller * temos a Home
/api/v1/carros

Tecnologias 
- Spring Boot
- Banco de Dados MySql
- Lombok
- API com swagger

![Descrição da Imagem](https://github.com/thiag0ferreira/springboot/blob/master/mysql.png)

