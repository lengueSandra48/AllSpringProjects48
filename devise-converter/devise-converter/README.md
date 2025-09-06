# API de Gestion de Tâches - ToDo List

## 📌 Fonctionnalités
 Endpoint de conversion prenant en entrée la devise source, la devise
   cible et le montant.
 Appel à une API externe pour obtenir les taux de change (ex :
   Exchangerate-API).
 Gestion des erreurs (devise invalide, problème de connexion à l’API
  externe).


Prérequis :

IDE recommandé : IntelliJ IDEA Outils de test : Swagger UI ou Postman Environnement : JDK 21 et Maven Importation du projet : Ouvrir le dossier du projet dans IntelliJ IDEA Laisser l'IDE configurer les dépendances automatiquement



## 🚀 url pour tester l'application sur swagger
👉 http://localhost:8080/swagger-ui.html
ou
👉 http://localhost:8080/swagger-ui/index.html

## 🚀 Commande pour le lancement de l'application
```bash

ou utilisez le bouton "run" de votre IDE comme intellij par exemple.
exemple de requête:
{
  "from": "usd",
  "to": "eur",
  "amount": 50
}
{
  "from": "eur",
  "to": "usd",
  "amount": 150
}
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}