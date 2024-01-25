# Projet de la Coupe du Monde 2030 au Maroc

## Table de matière

1. [Introduction](##1-introduction)
2. [Objectifs du projet](##2-objectifs-du-projet)
3. [Technologies](##3-technologie)
4. [Structure du projet](##4-structure-du-projet)

    4.1 [Front end - Angular](###41-front-end---angular)

    4.2 [Back end - Spring boot](###42-back-end---spring-boot)

5. [Conclusion](##5conclusion)
## 1. Introduction
Notre vision est de créer une application web pour la Coupe du Monde 2030 au Maroc, où les fans de football du monde entier pourront non seulement suivre l'actualité des matchs, mais aussi explorer et célébrer la culture marocaine. En unissant sport, tourisme et technologie, l’idée vise à laisser une empreinte positive et à promouvoir le Maroc comme destination culturelle incontournable. Nous aspirons à créer des souvenirs impérissables pour les visiteurs et à soutenir le développement durable du Maroc à travers l’exposition de sa riche diversité culturelle.

![Home page](/src/main/resources/photo/home.jpeg)

## 2. Objectifs du projet
**Gestion des Matches :** Le site offre une fonctionnalité de suivi des matches en temps réel, fournissant des informations détaillées sur les équipes, les horaires et les résultats.

![Match page](/src/main/resources/photo/match.jpeg)

**Tourisme et Culture :** Intégration de recommandations touristiques, mettant en avant la riche culture marocaine, des guides pour explorer les sites historiques.

![Culture page](/src/main/resources/photo/monument.png)

**Exploration Culturelle :** L'application permet aux utilisateurs d'explorer la richesse culturelle du Maroc, mettant en avant sa cuisine, ses monuments et d'autres éléments emblématiques.

![Cuisine page](/src/main/resources/photo/food.jpeg)

**Suivi des Équipes et Joueurs :** Offrir un suivi des équipes, des joueurs et des entraîneurs.

![Players and teams page](/src/main/resources/photo/teams.jpeg)
![Players and teams page](/src/main/resources/photo/players.jpeg)
## 3. Technologies
**Angular(Front End) :** est un framework open source développé par Google pour construire des applications web dynamiques et interactives côté client

**MongoDB (Base de Données) :**  est une base de données NoSQL, orientée document, permettant de stocker des données sous forme de documents JSON. 

**Spring Boot (Back End) :** est un framework Java qui simplifie le développement d'applications basées sur Spring.

**Eureka (Microservices - Service de Découverte) :** est un service de découverte de microservices développé par Netflix.

**Spring Security et JWT (Authentification) :** Spring Security est une extension de Spring qui offre des fonctionnalités d'authentification et d'autorisation pour les applications Java. JWT (JSON Web Token) est un format ouvert standard permettant de représenter des réclamations entre deux parties de manière sécurisée, souvent utilisé pour l'authentification dans les applications web.

**API Gateway (Microservice) :** est un composant qui agit comme une porte d'entrée centralisée pour l'accès aux différents microservices.

## 4. Structure du projet
### 4.1 Front end - Angular

Le dossier "frontend" englobe la logique côté client développée avec Angular. La structure se compose de plusieurs sections clés :

**acceuil :** Contient les composants et fichiers dédiés à la page d'accueil, avec des éléments visuels et fonctionnels spécifiques à cette section.

**admin-layout :** Regroupe les composants et fichiers pour la mise en page de l'interface administrateur, intégrant des fonctionnalités spécifiques à l'administration.

**auth-layout :** Englobe les composants liés à l'authentification et à l'autorisation, pouvant inclure des formulaires de connexion et d'inscription.

**client-layout :** Comprend les composants pour la mise en page destinée aux utilisateurs clients, avec des fonctionnalités adaptées aux utilisateurs finaux.

**destination-layout :** Rassemble les composants liés à la gestion des destinations touristiques, incluant l'affichage, la recherche, et d'autres fonctionnalités liées au tourisme.

**home :** Contient des composants spécifiques à la page d'accueil, facilitant la première interaction des utilisateurs avec l'application.

**reco-layout-component :** Dossier dédié aux composants liés à la mise en page des recommandations touristiques, pouvant inclure des fonctionnalités de recommandation personnalisée et d'affichage des points d'intérêt.

**app-routing.module.ts :** Définit les routes de l'application pour une navigation fluide entre les différentes pages et mises en page.

**app.component :** Définit le composant racine de l'application, agissant comme le point d'entrée principal, avec la spécification du modèle et du style associés.

**app.module.ts :** Fichier crucial déclarant et important tous les modules nécessaires à l'application, organisant les dépendances et initialisant l'application.

**service.service :** Fichier de service définissant les services Angular pour la gestion des données et des fonctionnalités à travers l'application.

__*Accueil :*__

Le header de CupExplorer est minutieusement conçu pour offrir une expérience utilisateur intuitive et accessible.
Ce qui nous donne cette interface :   
 
![Acceuil page](/src/main/resources/photo/home.jpeg)

Et pout le footer : 

![Footer page](/src/main/resources/photo/footer.png)


__*Section d'Accueil :*__

Le composant Home met en lumière le Maroc en tant que pays hôte de la Coupe du Monde 2030. Il offre une introduction à Visit Morocco, encourage l'exploration des villes hôtes, présente des informations sur les destinations, expose les équipes de villes avec des liens pour en savoir plus, et propose des recommandations de services de voyage diversifiés. Les sections clés comprennent "À Propos de Nous" ("About Us"), "Destinations" ("Destination"), "Équipes" ("Team"), et "Services". L'objectif de cette composante est de fournir une expérience immersive incitant à découvrir la culture, les traditions, et les services exceptionnels du Maroc.

![Home1 page](/src/main/resources/photo/homeSection.png)

![Home2 page](/src/main/resources/photo/homeSec2.png)

__*Authentification :*__

L'interface d'authentification se présente sous la forme d'un formulaire élégant. Elle offre aux utilisateurs la possibilité de s'inscrire avec leur adresse e-mail et mot de passe

![auth page](/src/main/resources/photo/auth.png)

### 4.2 Back end - Spring boot


Cette section présente la structure détaillée de la partie backend, mettant l'accent sur les composants clés tels que les modèles, les interfaces de repos, les services, les implémentations de services, et les contrôleurs REST.

![codeStructure page](/src/main/resources/photo/codeStructure.png)

__*Modèles (Model)*__

Les modèles représentent les données métier de l'application. Ce sont des objets simples qui encapsulent les informations nécessaires. Dans le contexte de la Coupe du Monde 2030 au Maroc, des modèles comme Match, Équipe, Joueur, etc., sont créés pour représenter les entités liées au football.

__*Interfaces de Repos (Repository)*__

Les interfaces de repos définissent les opérations de base pour accéder et manipuler les données dans la base de données.  Ces interfaces étendent généralement les interfaces fournies par Spring Data JPA, pour notre cas, Spring Data pour MongoDB,facilitant ainsi les opérations courantes telles que la récupération, l'ajout, la mise à jour ou la suppression de données.

__*Services*__

Les services représentent la couche métier de l'application. Ils implémentent la logique métier spécifique à l'application. Les services interagissent souvent avec les interfaces de repos pour accéder aux données nécessaires à l'application.

__*Implémentations de Services (Service Implementation)*__

Les implémentations de services sont les classes concrètes qui fournissent l'implémentation réelle de la logique métier définie dans les services. Ces classes interagissent avec les interfaces de repos pour accéder à la base de données et effectuer des opérations sur les données.

__*Contrôleurs REST (RestController)*__

Les contrôleurs REST exposent les fonctionnalités de l'application en tant qu'API RESTful. Ils répondent aux requêtes HTTP en invoquant les méthodes appropriées des services. Les contrôleurs sont responsables de la gestion des entrées HTTP, de l'appel des services nécessaires, et de la création des réponses HTTP.

#### Structure des Microservices

_**Microservices - Eureka :**_ Eureka est utilisé comme service de découverte, facilitant la gestion et le déploiement des microservices.

_**Microservice Principal :**_ Ce microservice englobe les classes liées aux matchs, équipes, joueurs, entraîneurs, villes et événements, avec des fonctionnalités d'authentification et de sécurité où nous avons intégré Spring Security pour garantir un accès sécurisé aux fonctionnalités de l'application. La gestion des jetons JWT (JSON Web Tokens) renforce l'authentification, garantissant une expérience utilisateur sécurisée.

_**Microservice Cuisine :**_ Ce microservice met en avant la classe dédiée à la cuisine marocaine, offrant une expérience sensorielle complète aux utilisateurs.

_**Microservice Monument :**_ Ce microservice présente la classe dédiée aux monuments de chaque ville, permettant aux utilisateurs de découvrir le patrimoine culturel du Maroc.

_**Microservice API Gateway :**_ L'API Gateway facilite le routage entre les microservices et le front end, agissant comme une porte d'entrée centralisée.

## 5. Conclusion

Le Projet de la Coupe du Monde 2030 au Maroc, avec son application web innovante, se positionne comme un catalyseur pour la promotion du Maroc en tant que destination culturelle de renom. En combinant le sport, le tourisme et la technologie de manière harmonieuse, nous aspirons à laisser des souvenirs impérissables aux visiteurs et à contribuer au développement durable du Maroc. Ce projet repose sur des technologies de pointe et une architecture de microservices pour assurer une expérience utilisateur optimale et sécurisée.
