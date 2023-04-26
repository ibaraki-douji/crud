J'ai utilisé le framework Spring Boot pour pouvoir avoir un CRUD fonctionnel et une interface graphique pour tester les fonctionnalités (Swagger).

CODE :

Classe principale d'initialisation Spring Boot

![](./assets/crud.jpg)

Classe de la définition d'un apprenti

![](./assets/entity.jpg)

Classe d'accès a la base de donnée (éléments de base gérer par Spring boot)

![](./assets/repo.jpg)

Classe de logique métier (services)

![](./assets/service.jpg)

Classe de gestion des endpoints de l'API

![](./assets/controller.jpg)

Maintenant qu'on a toutes les classes on peut passer aux test via Swagger.

![](./assets/swagger.jpg)

J'ai testé pour le readme le getAll

![](./assets/getAll.jpg)

Ensuite le getAllByOrder

![](./assets/getAllOrder.jpg)

Pour finir l'erreur de création avec le même email

![](./assets/noSameNameOnCreate.jpg)

Pour tester le programme il vous faut une BBD MySQL et modifier/créer la bonne configuration dans `application.properties`. De plus il faut installer les prérequis Spring Boot pour l'IDE.