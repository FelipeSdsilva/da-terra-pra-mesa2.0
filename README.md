# Da Terra pra Mesa 2.0

Esse projeto tem como ser um monorepo (Onde consiste backend e frontend no mesmo repositório do GitHub) catalogo de produtos que tem como finalidade uma melhora do projeto integrador da Generation Brasil link da Versção 1.0
(https://github.com/GenerationProjects/projeto-da-terra-pra-mesa).

## Projeto integrado para atender a ODS nº 2 "Fome zero e agricultura sustentável".

Tem como objetivo atingir um público de pequenos produtores agricultores, ajudá-los a gerar renda ao mesmo tempo que conseguimos repassar renda para ONG´s que cuidam de pessoas vulneráveis e ajudam a combater a fome da sociedade.

# Passos Para Inicialização e Metas para esse Projeto.

- [x] Inicialização do Projeto via https://start.spring.io/.
    - [x] Escolhendo liguagem Java 17 e gerenciador de dependência Maven.
    - [x] Colocando nome(Group, Artifact, Name, Description).
    - [x] Incluindo dependências (H2, JPA e Spring Web).

- [x] Alterando o pom.xml incluindo plugin para compatiblidade.

```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version> <!--$NO-MVN-MAN-VER$ -->
</plugin>
```
- [ ] Criar classes de negocio.
    - [ ] Produto.
    - [ ] Categoria.
    - [ ] Usuário.
    - [ ] Regras.