# Movies Now (App de lista de filmes)

Este é um projeto com Jetpack Compose e kotlin, moderno, utiliza Material 3 do android, consome uma
API de filmes mocada, sem dependências externas de servidor local.

### 📦 Estrutura

Arquitetura MVVM:

- Models/: Modelo do filme
- ViewModels/: ViewModel que faz a requisição para o serviço manualmente, e se comunica com a View.
- Views/: Interface com Jetpack Compose.

- Repository/: Chamadas e a comunicação com a API.
- Resources/: Arquivo Json para mocar a API, e arquivo de strings.

Utilitários:

- Util/: Para mocar um filme e usa-lo nos Previews.

### Para interface gráfica Jetpack Compose:

- Escolhido por ser declarativo e reativo, sendo a maneira mais moderna de construir telas.

### 🚀 Uso

Sem dependências externas, basta rodar o app.

Tela de lista de filmes:

- Listar filmes com: imagem, título, ano e nota.

Tela de detalhes do filme:
Ao selecionar um filme mostrar:

- Imagem de destaque
- Título
- Descrição
- Ano de lançamento
- Duração
- Nota (ex: 8.7/10)
- Miniplayer com o video embedded
- Consumo via API mocada.

Os dados da API estão no JSON.

### Boas práticas aplicadas

- Componentização das views, facilitando a reutilização do @Composable.
- Separação de responsabilidades.
- Tratativas de erro.
- Uso do Material 3 do Android.

### Diferenciais

- Testes unitários
- Jetpack Compose
- Guidelines