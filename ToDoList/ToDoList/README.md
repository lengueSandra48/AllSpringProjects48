API de Gestion de Tâches - ToDo List
📌 Fonctionnalités
📄 Créer une tâche
📋 Lire toutes les tâches (filtrables par statut)
📝 Modifier une tâche
🗑️ Supprimer une tâche
Prérequis :

IDE recommandé : IntelliJ IDEA
Outils de test : Swagger UI ou Postman
Environnement : JDK 21 et Maven
Importation du projet : Ouvrir le dossier du projet dans IntelliJ IDEA Laisser l'IDE configurer les dépendances automatiquement

Créer une base de données PostgreSQL nommée todolist via pgAdmin, ou alors vous pouvez aussi aussi créer une base de donnée avec un autre nom, il vous suffira juste de modifier les informations de l'application dans le fichier "application.properties" ou "application.yml" pour les adapter aux votres.

Compilation et lancement : Compiler le projet Lancer l'application via la classe principale (annotée @SpringBootApplication) en utilisant le bouton "run" de votre IDE intellij

🚀 url pour tester l'application sur swagger
Accès à l'interface Swagger : Ouvrir un navigateur web Accéder à : 👉 http://localhost:8080/swagger-ui.html ou 👉 http://localhost:8080/swagger-ui/index.html

Vous devriez voir la documentation interactive de l'API Tester un endpoint (exemple POST) : CAS D'UN AJOUT DE TACHE Dans Swagger UI :

Sélectionner le contrôleur POST Créer une nouvelle tache Développer POST Cliquer sur "Try it out" Modifier le JSON avec cette requette par exemple : { "titre": "Faire les courses", "description": "Acheter du lait et des œufs", "statut": "EN_COURS" }

Cliquer sur "Execute" Vérifier :

Response body : Vous verez la tache que vous venez de créer avec les détails Code réponse : 200 OK

Tester un endpoint (exemple PUT) : CAS DE MISE A JOUR D'UNE TACHE Dans Swagger UI : Sélectionner le contrôleur PUT Met à jour une tache Cliquer sur "PUT" pour développer la section Cliquer sur "Try it out" Dans le corps de la requête : Remplacer le contenu exemple par vos données Exemple : { "titre": "Faire les courses", "description": "Acheter du lait et des œufs", "statut": "EN_COURS" }

Supprimer l'id (généré automatiquement) Renseigner les champs obligatoires (titre, description, statut)

Cliquer sur "Execute" Vérifier la réponse "les nouvelles données mise à jour" si tout s'est bien passé

Response body : Vous verez la tache que vous venez de créer avec les détails Code réponse : 200 OK