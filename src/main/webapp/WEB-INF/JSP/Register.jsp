<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    /* Style CSS pour le formulaire */
    form {
      margin: 0 auto;
      max-width: 600px;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #f7f7f7;
    }
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
    input[type="text"], input[type="email"], input[type="tel"], input[type="password"] {
      display: block;
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      border: 1px solid #ddd;
      border-radius: 5px;
    }
    input[type="text"]:focus, input[type="email"]:focus, input[type="tel"]:focus, input[type="password"]:focus {
      border-color: #337ab7;
      outline: none;
    }
    .form-actions {
      margin-top: 20px;
      text-align: right;
    }
  </style>
<meta charset="UTF-8">
<title>Créer un profil utilisateur</title>
</head>
<body>
<h1>Créer un profil utilisateur</h1>
  <form action="#" method="post">
    <!-- Champ Prénom -->
    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" required>

    <!-- Champ Nom -->
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" required>

    <!-- Champ Pseudo -->
    <label for="pseudo">Pseudo :</label>
    <input type="text" id="pseudo" name="pseudo" required>

    <!-- Champ Email -->
    <label for="email">Email :</label>
    <input type="email" id="email" name="email" required>

    <!-- Champ Téléphone -->
    <label for="telephone">Téléphone :</label>
    <input type="tel" id="telephone" name="telephone" required>

    <!-- Champ Rue -->
    <label for="rue">Rue :</label>
    <input type="text" id="rue" name="rue" required>

    <!-- Champ Ville -->
    <label for="ville">Ville :</label>
    <input type="text" id="ville" name="ville" required>

    <!-- Champ Code Postal -->
    <label for="codepostal">Code postal :</label>
    <input type="text" id="codepostal" name="codepostal" required>

    <!-- Champ Mot de passe -->
    <label for="motdepasse">Mot de passe :</label>
    <input type="password" id="motdepasse" name="motdepasse" required>

    <!-- Champ Confirmation du mot de passe -->
    <label for="confirmation">Confirmer le mot de passe :</label>
    <input type="password" id="confirmation" name="confirmation" required>

    <!-- Boutons Créer et Annuler -->
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Créer</button>
      <button type="button" class="btn btn-secondary">Annuler</button>
    </div>
    </form>
</body>
</html>