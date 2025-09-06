Prérequis :

IDE recommandé : IntelliJ IDEA
Outils de test : Swagger UI ou Postman
Environnement : JDK 21 et Maven
Étapes pour lancer et tester l'API :


Importation du projet :
Ouvrir le dossier du projet dans IntelliJ IDEA
Laisser l'IDE configurer les dépendances automatiquement
création de la base de donnée :

Créer une base PostgreSQL nommée productDB via pgAdmin, vous pouvez aussi créer une base de donnée avec un autre nom il vous suffira juste de modifier les informations de configuration de la base de données dans le fichier "application.properties" pour les adapter aux votres.



Compilation et lancement :
Compiler le projet
Lancer l'application via la classe principale (annotée @SpringBootApplication) à travers le bouton run de IntelliJ



Accès à l'interface Swagger :
Ouvrir un navigateur web
Accéder à : http://localhost:8080/swagger-ui/index.html
Vous devriez voir la documentation interactive de l'API


Tester un endpoint (exemple POST) Pour créer un produit dans Swagger UI :

Trouver la section correspondant à votre contrôleur
Cliquer sur "POST" pour développer la section
Cliquer sur "Try it out"
Dans le corps de la requête :
Remplacer le contenu exemple par vos données

{
  "name": "Huile vegetale",
  "price": 10000,
  "quantity": 1
}

Supprimer l'id (généré automatiquement)
Renseigner les champs obligatoires (name, price, quantity)
Cliquer sur "Execute"

Vérifier la réponse vous verez le nouveau produit créé avec tous ses détails avec un response body contennat les données du produit que vous venez de créer et un code 200 OK si tout s'est bien passé.



Tester un endpoint (exemple GET) Pour vérifier les produits qui sont en baisse de stock (stock < 5) dans Swagger UI :

Trouver la section correspondant à votre contrôleur
Cliquer sur "GET" pour développer la section
Cliquer sur "Try it out"

Cliquer sur "Execute"

Vérifier la réponse vous verrez tous produits qui ont une quantité en stock inférieur à 5 avec tout leurs détails  avec un response body contennat les données de chacun de ces produits et un code 200 OK si tout s'est bien passé.
