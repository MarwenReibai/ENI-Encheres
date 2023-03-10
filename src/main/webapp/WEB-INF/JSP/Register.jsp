<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    /* Style CSS pour le formulaire */
    form {

    }
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
    input[type="text"], input[type="email"], input[type="tel"], input[type="password"] {
      display: block;
      width: 100%;
      padding: 5px;
      margin-bottom: 5px;
      border: 1px solid #ddd;
      border-radius: 5px;
    }
    input[type="text"]:focus, input[type="email"]:focus, input[type="tel"]:focus, input[type="password"]:focus {
      border-color: #337ab7;
      outline: none;
    }
    .form-actions {
      margin-top: 20px;
      text-align: center;
    }
    .titre {
    text-align: center;
    }
    .right {
   
      display: inline-block;
 	  justify-content: space-between;
  	  align-items: center;
      margin: 0 auto;
      max-width: 600px;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #f7f7f7;
    }
    
    .left {
	
	  display: inline-block;
  justify-content: space-between;
  align-items: center
	      margin: 0 auto;
      max-width: 600px;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #f7f7f7;
    }
    
    .error {
	    display: flex;
	    justify-content: center;
    }
  </style>
<meta charset="UTF-8">
<title>Créer un profil utilisateur</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1 class="h3 mb-3 mt-5 fw-normal title titre">Mon Profil</h1>
  <form class="titre" action="/Encheres/Register" method="post">
  <div class="right">
    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" required>

    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" required>

    <label for="pseudo">Pseudo :</label>
    <input type="text" id="pseudo" name="pseudo" required>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" required>

    <label for="telephone">Téléphone :</label>
    <input type="tel" id="telephone" name="telephone" required>
  </div>
  <div class="left">
    <label for="rue">Rue :</label>
    <input type="text" id="rue" name="rue" required>

    <label for="ville">Ville :</label>
    <input type="text" id="ville" name="ville" required>

    <label for="codepostal">Code postal :</label>
    <input type="text" id="codepostal" name="codepostal" required>

    <label for="motdepasse">Mot de passe :</label>
    <input type="password" id="motdepasse" name="motdepasse" required>

    <label for="confirmation">Confirmer le mot de passe :</label>
    <input type="password" id="confirmation" name="confirmation" required>
</div>
	<%
    	String erreur = (String)request.getAttribute("erreur");
    	if ( erreur != null) {
    %>
    <div class="error">
    
    	<div class="alert alert-danger mt-3 w-25" role="alert">
  			<%= erreur %>
		</div>
		</div>
	<% } %>
  
    <!-- Boutons Créer et Annuler -->
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Créer</button>
      <button type="button" class="btn btn-secondary">Annuler</button>
    </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>