# RickAndMortyApiFlow
# Android Architecture: Paggin 3, MVVM, Flow, Retrofit2, Dagger-Hilt

## O que é a biblioteca de paginação (Paging 3)
<div align="justify">
A biblioteca Paging ajuda você a carregar e exibir páginas de dados de um conjunto de dados maior do armazenamento local 
ou pela rede. Essa abordagem permite que seu aplicativo use a largura de banda da rede e os recursos do sistema com mais 
eficiência.<br></p>

### Arquitetura da Biblioteca
![img.png](img.png)

* Camada do repositório<br></p>
Um PagingSourceobjeto pode carregar dados de qualquer fonte única, incluindo fontes de rede e bancos de dados locais.<br></p>
Um RemoteMediatorobjeto manipula a paginação de uma fonte de dados em camadas, como uma fonte de dados de rede com um cache de banco de dados local.<br></p>

* Camada ViewModel<br></p>
 O Pagercomponente fornece uma API pública para construção de instâncias PagingDataque são expostas em fluxos reativos, com base em um PagingSourceobjeto e um PagingConfigobjeto de configuração.<br></p>
Um PagingDataobjeto é um contêiner para um instantâneo de dados paginados. Ele consulta um PagingSourceobjeto e armazena o resultado.<br></p>

* Camada de interface do usuário<br></p>
O componente primário da biblioteca de paginação na camada de interface do usuário é PagingDataAdapterum RecyclerViewadaptador que manipula dados paginados.<br></p>
Saiba mais sobre a biblioteca [Paging3](https://annchar.medium.com/android-paging-3-library-with-offset-and-limit-parameters-mvvm-livedata-and-coroutine-part1-5f85aa4fd29a)
</div>


## O que é a MVVM (Model-View-ViewModel)
<div align="justify">

MVVM é um padrão de projeto baseado em UI, ele é uma aplicação do MVP, que é uma derivação do MVC. Estes padrões de projeto (MVC, MVP e MVVM) procuram atingir os mesmos objetivos mas com soluções diferentes.<br></p>

## Objetivos
* Rich UI (interface rica)
* Testabilidade
* Modularidade
* Facilidade de manutenção
* Flexibilidade


## História do MVVM
MVVM foi introduzido em 2005 por John Gossman, na Microsoft, para ser usado com WPF (Windows Presentation Foundation) sendo uma aplicação concreta do MVP, descrito por Martin Fowler.<br></p>
O MVVM como implementação do MVP usa varias capacidades específicas disponíveis em WPF, Silverlight, Windows Universal Platform (UWP). Algumas implementações do MVVM tais como MvvmCross, MVVM Light disponibilizam esse padrão para Xamarin.android e Xamarin.iOS.<br></p>

### MVVM Princípios
MVVM tem alguns princípios que quando seguidos, facilitam a sua implementação.<br></p>

Princípio da Simplicidade: Cada View deveria ter uma única ViewModel e uma ViewModel deveria fornecer serviços para uma única View.<br></p>

Princípio da Blendability: Quando usado em plataforma Windows, deveria suportar o uso da ferramenta Blend (instalada junto com o Visual Studio).<br></p>

Princípio de Designability: A ViewModel deveria disponibilizar dados para ser utilizados em Design Time.<br></p>

Princípio da Testabilidade: As ViewModels e Models devem permitir/facilitar o uso de testes.<br></p>

### Arquitetura MVVM
![image](https://user-images.githubusercontent.com/34040590/196055158-a1a74871-c977-43c0-866d-e64d592baa5c.png)

* View<br></p>
A View é a interface com o usuário, uma tela, uma janela ou uma interface de entrada e saída qualquer. 
A ligação entre a View e a ViewModel ocorre através da propriedade DataContext da View. 
DataContext armazena uma referência para a ViewModel e assim através de data binding e commands a View se comunica com a ViewModel e tem acesso as atividades e dados fornecidos pela ViewModel. 
A View não executa nenhuma operação no sistema. Ela simplesmente apresenta informações ao usuário e responde à essa interação de forma visual. 
A View apenas interage com o usuário. 
Por exemplo, numa caixa de texto, o usuário consegue ler ou escrever dados, mas não é tarefa da View validar esses dados ou envia-los para uma base de dados.

* ViewModel<br></p>
ViewModel é uma classe não visual, que dá vida a uma View. 
A ViewModel não tem nenhuma ligação com a View, nenhuma referência, ela simplesmente fornece os dados e executa ações que a View necessita. 
A ViewModel se comunica com a View por expor suas propriedades e através de bindings “notifica” a View sobre alguma alteração nos dados, ou atualiza os dados quando modificados pela View. 
Uma ViewModel implementa algumas interfaces, tais como: INotifyPropertyChanged, INotifyCollectionChanged, ICommand, etc. 
A ViewModel se conecta diretamente com o Model. Tendo acesso as propriedades e funcionalidades disponibilizadas pelo Model. 

* Model<br></p>
O Model é a classe que contém os dados da sua aplicação, como empregado, produto, cliente, etc…
O Model define uma série de propriedades e métodos. Você pode criar um Modeldo zero ou obte-lo através de um ORM tipo Entity Framework ou ainda através de um servidor REST convertido do JSON, por exemplo.

* Data Binding<br></p>
Data Binding é o meio de comunicação entre uma View e uma ViewModel.
Se a associação, binding, possui as configurações corretas e os dados fornecem as notificações adequadas, então, quando os dados mudam de valor, os elementos visuais que estão vinculados aos dados refletem alterações automaticamente e vice versa.

Geralmente o Model também é responsável pela validação dos dados.

Saiba mais sobre [MVVM](https://medium.com/netcoders/introdu%C3%A7%C3%A3o-ao-mvvm-model-view-viewmodel-cb5920b4ca58)
</div>
