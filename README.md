# Reactive-Rest-API-Reactive-Spring-Web-Flux-and-Mongodb

Dans une architecture web utitilsant un modele Mutli threads bloquant, le serveur cree un thread qui va s'occuper de chaque requete, cette methode marche bien mais possede beaucoup d'inconvenient vu que le systeme est bloquant c'est a dire que toutes les operations s'effectue de maniere synchrone

ex: 
Quand le client tente une requete avec connexion lente on racontrera des problemes de lentance et le systeme n'exploitera pas au mieux les capacites du serveur car tout se passe de maniere synchrone, mais dans un system dit reactive on utile un event loop qui va gerer toutes requetes mais cette fois le systeme ne sera pas blaquant tout se fera de maniere asynchrone.
