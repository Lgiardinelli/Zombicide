# l2s4-projet-2024

# Equipe

- Léo GIARDINELLI
- Théophane LEGRAND
- Dylan LEMAIRE
- Elies PLACIDE

# Sujet

[Le sujet 2024](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf)

# UML

![UML](image/uml_map.jpg)

# Livrables

## Livrable 1
### Objectif du premier livrable 
Travailler sur la modélisitation de la map et créer un algorithme de création, créer un plateau d'entrainement.

### Choix de modélisation 
Dans un tout premier temps, il s'agissait de créer un plateau représentant la ville par des listes et de Streets et de Building.  
Après réflexion, on a vite compris que créer une classe Building serait inutile et que garder seulement les objets de type Room serait plus optimal.  
Nous avons également convenu qu'il serait préférable d'utiliser des tableaux pour modéliser la ville, comme le tp de BattleSHip réalisé au S3.    
Nous avons donc décidé d'ajouter dans un premier temps les rues tant que la ville pouvait être divisée en prenant en compte les contraintes imposées (un batiment doit faire au minimum 2 de largeur et longueur).  
Ensuite il s'agissait de placer les pièces spéciales (Continental et Pharmacie), nous avons créé une méthode qui permettait de prendre une position aléatoire dans la ville et de vérifier si elle etait null (pour éviter de tomber sur une steeet), puis donc de l'assigner à cette position.  
Enfin, nous avons rempli les zones vides par des Rooms qui sont ajoutée dans une liste de room.   
Cette liste vas permettre en itérant dessus, de fermer les portes parmis toutes les positions (UP, DOWN, LEFT, RIGHT) car de bases, toutes les portes de toutes les cellulles sont ouvertes.  
Ce qui donne l'affichage idéal de MiniCityMain (la ville d'entraînement).  

### Etat du développement 
- La modélisation de la carte est terminée avec en supplément l'ajout des portes.
- Test unitaire fonctionnel sur la modélisation de la map (à mettre a jour pendants l'intégration des acteurs et des items).  

### Atteinte des objectifs
- Modélisation de la carte est complète.
- Les portes ont été ajoutée avec succès.
- Les tests unitaires sur la modélisation de la map sont terminée.

### Ensemble des commandes 
- Compilation
```bash
javac -sourcepath src src/zombicide/*.java -d classes
```
- Exécution du programme (avec 2 paramètres longueur et largeur du tableau ou non, 10 par 10 de base)
```bash
java -classpath classes zombicide.Main 10 10
```

- Tests compilation
```bash
javac -classpath junit-console.jar:classes test/zombicide/*.java
```

- Javadoc
```bash
javadoc -sourcepath src -subpackages zombicide -d docs
```

- Test exécution
```bash
java -jar junit-console.jar -classpath test:classes -scan-classpath
```

- Jar compilation
```bash
jar cvfe livrable1.jar zombicide/Main -C classes .
```
- Jar exécution
```bash
java -jar livrable1.jar 10 10
```


### Difficultés restant à résoudre
Aucune difficulté majeure n'a été identifiée jusqu'à présent.


## Livrable 2
### Objectif du premier livrable 
Modélisation des acteurs et des équipements.

### Choix de modélisation 

- Concernant les acteurs: 
Nous avons remarqué que les survivants et les zombies avaient les points d'action et les points de vie en commun. Il s'agissait donc de créer une classe mère qui hérite des classes Survivor et Zommbie. Les types de Zombies seront des classes filles de la classe Zombie, avec des caractéristiques différentes selon le type de Zombie. Les rôles des joueurs seront gérés dans une liste de "rôles" présente dans la classe Survivor. La classe Rôle est donc une classe abstraite qui hérite différentes classes qui représentent les rôles disponibles.

- Concernant les équipements:
Nous avons décidé de créer une interface qui représentera les équipements. Nous avons ensuite "séparé" les types d'équipements en deux catégories principales: les armes et les autres. La classe Weapon est une classe abstraite 

### Etat du développement 

### Atteinte des objectifs

### Ensemble des commandes

### Difficultés restant à résoudre

## Livrable 3

### Objectif du premier livrable 

Modélisation des actions.

### Choix de modélisation 

### Etat du développement 

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Objectif du premier livrable 

Modélisation complète.

### Choix de modélisation 

### Etat du développement 

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
Together, we created our first version of the UML with all the classes and the first methods and attributes.  
Then, over the next few days, we completed it and divided up the various classes to be coded.  
Léo -> Area.java  
Dylan -> Door.java  
Elies -> City.java  
Théophane -> Building.java  

## Semaine 2
__Objectif de la semaine : __ 
- Finir l'algorythme de création de la map
- Avancer sur la modélisation de la map

__Réflexion du groupe :  __
Durant la semaine, nous nous sommes posé plusieurs question, par exemple comment split la map pour créer les immeubles et comment le modéliser pour faire en sorte que quand une porte est cassé, supprimer dans l'affichage que cette porte.  
Nous avons premièrement écrit un algorithme non récursif puis avec de la récursivité mais celui-ci ne fonctionne pas car il split que 1 fois.  


__Partage de taches : __  


## Semaine 3
__Objectif de la semaine :__ 

- Finir la modélisation des portes
- Terminer la modélisation de la map
- Finir l'affichage de la map
- Finir les tests

__Objectif atteint :__

- Finir la modélisation des portes
- Finir les tests
 

__Réflexion du groupe :__  

Lundi 29/01 :
Durant ce lundi, nous avons réfléchi à la modélisation des portes, ce qui nous a amenés à la création d'une classe enum pour la position des portes avec l'ajout d'une hashmap enum/porte.

Cela nous a également amenés à réfléchir sur l'affichage de la map et l'affichage des portes (ouvertes et fermées), et nous avons réfléchi sur la méthode de splitHorizontal et splitVertical en la modifiant sur un split en croix.

Les jours suivants :
Nous avons réfléchi à si nous allions faire des méthodes de tests sur city et après plusieurs réfléxion sur l'utilité dans faire du fait que nous avions mis les méthodes en privée, nous n'avons pas fait de méthode de test pour city.

Vendredi 02/02 :
Après une réflexion de groupe à 4, nous avons décidé de revenir sur une version antérieure de City car la nouvelle version ne convenait pas par rapport à nos objectifs.

Week-end :
Pour pouvoir gerer les portes ouvertes, nous avons penser à regarder la cellulle du dessus pour savoir si la porte du bas était ouverte ou non, de même pour les autres côté. Le problème que nous avons eu est que si la celulle d'au dessus est une street, elle n'a pas de porte. 
En refléchissant en groupe, nous avons utilisé la solution de faire en sorte qu'une porte soit la même pour les pièces mitoyenne.
En créant cette méthode, nous l'avons testé et elle fonctionne bien, le problème étant que le code n'est très explicite, nous allons essayer de le simplifier.
Les portes sont crées comme voulues dans chaque zone, il faut règler l'affichage de ces dernières dans le cas ou la zone est une rue.
Le problème actuellement esEquipementt de pouvoir gerer l'affichage dans le cas où entre les street il n'y a pas de porte car comment savoir que deux streets sont a côté.

__Partage de taches :__

Lundi 29/01 :
- Groupe entier -> réunion des idées et réflexion sur la modélisation de la map et l'affichage des pièces et des portes.
- Dylan -> Terminer la modélisation de la map
- Elies -> Finir l'affichage de la map
- Théophane -> Mise en place et mise en forme du readme
- Léo -> Terminer la modélisation de la map

Les jours suivants :
    
- Dylan -> affichage des rues, finalisation des splits, affichage des portes et de leur état 
- Elies -> création de la méthode display, initialisation des rooms et ajout des portes
- Théophane -> Finir les tests
- Léo -> création des deux classes continentale et pharmacie + intégration des deux classes dans la ville

Mardi 30/01 :
    
- Elies -> test de la création display en initialisant des Room (sans méthode de split précise). Pour cela, j'ai amélioré la classe Room pour permettre l'ajout de portes 
   
Mercredi 31/01 :
    
- Dylan -> création de la logique de split terminée, plateau prêt à être utilisé notamment pour l'affichage des portes en fonction de leur état. Javadoc de la classe City mise à jour.

- Théophane -> Création des tests concernant la classe Room et la classe Door, les tests sont terminés concernant ces deux classes, suppréssion de la classe test street après réflexion sur son utilité, amélioration des méthodes de tests dans la classe test Area et réfléxion sur différentes methodes à revoirs

Jeudi 01/02 :

- Léo : Création des classes continental et pharmacie et début de code dans celle-ci.

- Théophane : Ajout de méthode canFight dans la pharmacie et le continental, test sur la pharmacie et le continental dans la class test area 

Vendredi 02/02 :

- Théophane : Modification des tests -> implémentation des beforeEach et ajout, modification de test 
- Léo : coder la méthode display pour avoir un affichage que l'oint souhaite, non fini.

Week-end :
- Léo, Dylan : Amelioration du display, travail à deux sur un seul écran.
- Dylan : Création des portes dans chaque zones, en prenant en compte le fait qu'une porte peut être dans deux pièces.
- Théophane, Elies : Mise à jour de l'UML en fonction des modifications qui ont été faites et completer le readme. 

## Semaine 4

__Objectif de la semaine :__  

- Finalisation de la modélisation de la ville.
- Finalisation de la gestion des portes pour les Rooms
- Finalisation de l'affichage de la ville
- Bien s'entendre sur le type modélisation des acteurs et des équipements que l'ont souhaite faire pour eviter les incompréhensions
- Avancer dans la modélisation des acteurs et des équipements.

__Objectif atteint :__
- Finalisation de la gestion des portes pour les Rooms
- Finalisation de l'affichage de la ville

__Réflexion du groupe :__  

Lundi 05/02 :

- On a d'abord réfléchi concernant la gestion des portes. En effet, il s'agissait de décider si les Street pouvaient elles aussi avoir des portes ( pour une gestion plus facile pour la méthode d'affichage de la ville) ou non. Cette option a été finalement choisie.

Mercredi 07/02 :
- Après de longues réflexions et plusieurs essaie de modélisation pour gerer les portes, nous avons réussi à résoudre cela en ouvrant les portes de toutes les cellulles à la création du plateau et en parcourant la liste des rooms, fermer les 4 côtés. Ce qui a permis d'avoir un plateau optimal et correspondant à nos attentes et objectifs.
- Ajout des constantes dans Area pour l'affichage des portes ouvertes et fermées pour éviter la redondance dans chaque classes pour la méthode display. Ce qui permettra si l'ont souhaite modifier l'affichage de modifier que dans la classe Area et non dans toutes les classes qui hérite de celle-ci. 

Week-end :
Nous avons discuté ensemble sur la suite du rendu pour le livrable deux et permettre de se coordonner pour au mieux se répartir les taches. Nous allons procéder de la même manière que le livrable 1, car tous le monde a travailler à son rythme et correctement avec une répartition des taches équitables.

__Partage de taches :__

Lundi 05/02 : 

- Eliès : création des classes liées aux survivants (Survivor, types de survivants). Ajout des classes BackPack et Role. 
         Ajout des paramètres liées aux caractéristiques des diverses armes ( points de dégats , seuil , etc...)

- Théophane : Création des classes liées aux zombies (Zombie, types de zombies), mise en place de l'uml dans le git et mise en forme du livrable 1 

- Léo, Dylan : Amelioration du display pour gerer les portes entre les streets et début de modification de code pour ajouter des constantes dans le but d'ameliorer le code si modification.

Les jours suivants :
    
Mardi 06/02 : 

- Eliès : réorganisation des packages pour une meilleure optimisation du projet. Il s'agissait notamment de gérer les classes liées à un héritage.
            Création des méthodes qui gérent une attaque avec les armes (lancer de dé et vérification pour voir si le seuil était dépassé)
            Mise à jour du readme 

- Théophane : Ajout des paramètres liées aux caractéristiques des divers zombies (points de vie , points d'action , etc...) et actualisation des tests unitaires

- Dylan : Remodélisation de la méthode qui ajoutait des portes aux zones de la ville pour finaliser son affichage complet.

Mercredi 07/02 :
- Léo, Dylan : 	Remodélisation des méthodes pour gerer toutes les portes qui doivent rester ouvertes (entre les streets), display fini. Finalisation du display des rooms spéciales (pharmacie et continental)

- Théophane : Ajout du package role avec les classes le concernant et modification des classes zombies pour ajouter des methodes les concernants
                Ajout des classes liées aux équipements (Item)

- Eliès : réalisation de la java doc sur plusieurs classes du projet.
            Ajout de méthodes pour la modélisation des Actor et des Survivor.

Week-end :
- Léo, Dylan, Elies, Théophane : Discussion de groupe pour le livrable 2 et maj du readme pour les prochaines semaines.


## Semaine 5
__Objectif de la semaine :__  

- Finir la modélisation complète des armes ( constructeur, attributs, héritage) 
- Finir la modélisation complète des équipements ( constructeur, attributs, héritage) 
- Ajout des acteurs dans le plateau. 
- Amelioration de l'affichage avec couleurs et zombies/survivants 

__Objectif atteint :__
- Amelioration de l'affichage avec couleurs et zombies/survivants
- Ajout des acteurs dans le plateau. 
- Finir la modélisation complète des armes ( constructeur, attributs, héritage) 
- Finir la modélisation complète des équipements ( constructeur, attributs, héritage) 

__Réflexion du groupe :__  

Lundi 12/02 :
On a pensé à modifier les classes relatant de Weapon car nous avions remarqué une certaine redondance par rapport à leurs caractéristiques pour le constructeur. En effet, on rappelait les attributs pour chaque arme pour modifier les stats. Nous avons donc créet un constrcuteur dans la classe abstraite Weapon ( il n'y en avaut pas à la base) pour ensuite le rappeler dans chaque classe fille avec les stats correspondantes.
Par rapport au display, nous avons schématisé ce à quoi ressemblera le display avec l'ajout des acteurs pour chaque cellule.

Mardi 13/02 :
La méthode display qui est dans area nous facilite grandement si l'ont veut faire de changement dans l'affichage, car elle impacte toutes les classes filles de celle-ci, c'est pour cela que nous allons garder cette modélisation.
Pour l'affichage, nous rencontrons un problème, en faisant une seule méthode display dans aréa pour qu'il n'y ait pas de redondance, il y a des bouches d'égouts qui ne sont pas affichées au bon endroit, tout comme la spawnstreet alors que avec le display dans chaque type de pièce cela fonctionnait. Nous sommes en train de voit où viens cet erreur pour pouvoir la gerer au plus vite.

Mercredi 14/02 :
Après réflexion, nous avons décidé de refactoriser le code permettant l'affichage afin de centraliser sa gestion uniquement dans la superclasse des zones. Afin d'éviter la redondance de ce dernier dans les classes enfants.
De plus, des couleurs seront ajoutées afin de simplifier la compréhension dans l'affichage de la console.  
Suite au mail reçu par notre chargé de TD, nous avons modifié les constantes que nous avons utilisé pour l'affichage soit remplacé par des méthodes qui vont nous permettre d'avoir quelque chose de dyamique.
Nous avons ajouté en plus pour pas surcharger l'affichage, fait en sorte que s'il n'y a pas de zombies ou de survivants dans une cellulle, le nombre et le nom de zombies/survivant ne soit pas affichés.

Vendredi 16/02 :
En ce qui concerne le spawn, nous en sommes convenu pour le moment qu'il était intéressant que le spawn soit une Street et non une classe à part entière. 
En effet dans le plateau d'entrainement il nous faut mettre le spawn sur une Manhole, ce qui était bloquant dans l'ancienne modélisation. 
Le spawn sera donc "sauvegardé" à sa création et ce en tant que Street.

Week-end :
Pour répartir les items dans les pièces de la map, nous avons pensé à choisir au hasard une rooms dans la liste des rooms que l'ont a créé à linitialisation et de lui ajouter dans sa liste d'items l'items correspondant.  
La question que nous nous sommes posé (et qui n'est pas écrit dans le sujet) est quels sont les items et combien doit-on en répartir, nous allons voir avec notre responsable lundi.  
Nous devons quand même gérer le fait que dans la liste des rooms, il y a les pièces spéciales (pharmacie et continental) où la pharmacie ne contient que des fioles et continental (pas plus d'information dans le sujet mais on suppose qu'il n'y a pas d'item car il n'y a pas d'attaque dans cette pièce).  
Pour cela, nous avons enlever l'ajout dans la liste rooms des pièces spéciales pour garder que celle "basique" et ajouter aléatoirement des items dedans.
Afin de simplifier la création du plateau d'entrainement, nous en sommes convenu qu'il était intéressant de créer une extension de City qui serait dédiée à ce cas de figure.
Ce puisque le plateau d'entrainement ne requiert qu'une seule Manhole qui plus est le spawn de ce dernier. Ainsi nous ne devons que redéfinir la logique de création du spawn et de la création de Manhole (ici aucune hormis le spawn créé au préalable).

__Partage de taches :__

Lundi 12/02 :

- Léo,Dylan : Gestion du display, anticipation par rapport à l'affichage des acteurs
- Théophane, Eliès: Modification des classes relatées à Weapon et Zombie (modifcation des attributs et des constructeurs)  

Mardi 13/02 :
- Léo, Dylan : Gestion du display pour un affichage optimal pour le nombre de zombie et de survivant.

Mercredi 14/02 :
- Léo, Dylan : Finalisation du display fonctionnel avec les objectifs que nous nous avons fixés.
- Théophane : Implémentation d'un Makefile pour l'automatisation des commandes java.

Jeudi 15/02 :


Vendredi 16/02 :
- Dylan : Modification de la logique de spawn par une variable de classe (statique) plutôt que d'utiliser une classe indépendante (voir réflexion de groupe). 
Cette variable consiste à stocker une instance de Street passée en paramètre d'un mutateur. Ainsi nous avons accès au spawn depuis sa création sans devoir se soucier s'il s'agit d'une Manhole ou d'une Street.
- Dylan : Début d'implémentation de la gestion d'action afin de pouvoir gérer les rôles de chaque joueurs. 
Pour le moment la gestion des Rôles se fait dans une classe abstraite, mais cette dernière pourrait devenir une interface si la modélisation ne requiert pas d'attributs communs entre chaque rôle.
- Théophane : Mise à jours des tests précèdent et implémentation de nouveaux tests pour les méthodes rajoutées cette semaine.

Week-end :
- Léo : insertion des items qui sont réparti dans les pièces de la map.
- Dylan : Gestion des exceptions au niveau des arguments passables à l'exécution du programme. Création de la classe TrainCity, implémentation de la logique différente en ce qui concerne le spawn et les Manholes de cette dernière.

## Semaine 6
__Objectif de la semaine :__ 

- Faire l'implémentation de la prise d'item 
- Faire l'implémentation de la methode enlever les items
- Mise en place des actions (package, classes)
- Finir le dispatching des items 


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 19/02 :

- Nous avons réfléchi sur la façon dont on pourrait modéliser les acteurs sur le plateau et comment pourrait t'on l'agencer, nous avons également réfléchi sur le comment modéliser les items dans les chambres et les conditions sur l'apparition et la disparition des items et backpacks et le dispatching.

Mardi 20/02 :


Mercredi 21/02 :


Jeudi 22/02 :


Vendredi 23/02 :


Week-end : Nous nous sommes tournés vers la gestion des déplacements de joueurs. Pour cela il s'agissait d'utiliser la clase MoveAction, qui prend comme attribut une direction. Cette comporte une méthode qui déplace un joueur passé en paramètre selon la direction correspondante de l'obet MoveAction. La direction, elle, est traduite par une énumération ActorDirection.



__Partage de taches :__

Lundi 19/02 :

- Théophane : Ajout de la méthode de bruit, ajout des packages et reflexion sur la modélisation des actions, et ajout de la limitation des skillsPoints à 30
- Eliès : Ajout des tests pour le backpack dans roomTest, ajout de la javadoc et ajout de la méthode toString pour chaque weapon

Mardi 20/02 :


Mercredi 21/02 :


Jeudi 22/02 :
- Théophane : Ajout de toutes les classes et interface concernant les actions et ajout de leurs méthodes pour gagner du temps sur leur création. Methode de test sur makeNoise dans ActorTest.

Vendredi 23/02 :


Week-end et durant les vacances :

- Eliès : ajout de l'énumération ActorDirection et finalisation de la classe MoveAction avec ses méthodes. Avancement dans la classe Test de MoveAction

## Semaine 7
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 11/03 :


Mardi 12/03 :


Mercredi 13/03 :


Jeudi 114/03 :


Vendredi 15/03 :


Week-end et durant les vacances :



__Partage de taches :__

Lundi 11/03 :


Mardi 12/03 :


Mercredi 13/03 :


Jeudi 114/03 :


Vendredi 15/03 :


Week-end :


## Semaine 8
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 18/03 :


Mardi 19/03 :


Mercredi 20/03 :


Jeudi 21/03 :


Vendredi 22/03 :


Week-end :



__Partage de taches :__

Lundi 18/03 :


Mardi 19/03 :


Mercredi 20/03 :


Jeudi 21/03 :


Vendredi 22/03 :


Week-end :


## Semaine 9
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 25/03 :


Mardi 26/03 :


Mercredi 27/03 :


Jeudi 28/03 :


Vendredi 29/03 :


Week-end :



__Partage de taches :__

Lundi 25/03 :


Mardi 26/03 :


Mercredi 27/03 :


Jeudi 28/03 :


Vendredi 29/03 :


Week-end :


## Semaine 10
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 01/04 :


Mardi 02/04 :


Mercredi 03/04 :


Jeudi 04/04 :


Vendredi 05/04 :


Week-end :



__Partage de taches :__

Lundi 01/04 :


Mardi 02/04 :


Mercredi 03/04 :


Jeudi 04/04 :


Vendredi 05/04 :


Week-end :


## Semaine 11
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 08/04 :


Mardi 09/04 :


Mercredi 10/04 :


Jeudi 11/04 :


Vendredi 12/04 :


Week-end :



__Partage de taches :__

Lundi 08/04 :


Mardi 09/04 :


Mercredi 10/04 :


Jeudi 11/04 :


Vendredi 12/04 :


Week-end :


## Semaine 12
__Objectif de la semaine :__  


__Objectif atteint :__


__Réflexion du groupe :__  

Lundi 15/04 :


Mardi 16/04 :


Mercredi 17/04 :


Jeudi 18/04 :


Vendredi 19/04 :


Week-end :



__Partage de taches :__

Lundi 15/04 :


Mardi 16/04 :


Mercredi 17/04 :


Jeudi 18/04 :


Vendredi 19/04 :


Week-end :

