SEATING PLAN – 24/04/2020 > 13/05/2020
Fonctionnalités de l’application
## Affichage de plusieurs plans
Un bâtiment peut être composé de plusieurs plans : un par étage, ou par
partie de bâtiment (ex : une aile ou une usine avec une partie bureaux et une
partie production). L’application doit pouvoir gérer plusieurs plans différents
(l’hypothèse peut être prise que tous les plans sont à la même échelle).
## Ajout de bureaux
L’application doit permettre l’ajout de bureaux. Ces bureaux seront tous
identiques. L’agencement de ces bureaux doit être flexible. Potentiellement,
le client peut décider de créer un groupe de 8 bureaux dans un espace
pouvant en contenir le double, puis revenir ultérieurement sur sa décision en
ajoutant 4 bureaux supplémentaires.
## Ajout/Sortie de collaborateurs
La société est rythmée par l’arrivée de collaborateurs et la sortie de certains.
Ces arrivées/sorties sont connues avec des dates. L’application doit pouvoir
permettre d’ajouter des collaborateurs avec une date d’arrivée dans le futur
et gérer le switching de bureau entre un collaborateur sur le départ et un
collaborateur arrivant prochainement.
## Affectation du collaborateur à un bureau
Dans la majeure partie des cas, tout collaborateur possède un bureau. Mais
ce n’est pas une règle. Un commercial itinérant par exemple n’aura pas de
bureau attitré. Il fait pourtant partie des effectifs et il serait bien de le voir 
apparaître dans les statistiques. Tout bureau ne possède pas forcément un
collaborateur (salle de réunion).
## Ajout de matériel (poste interne, ligne extérieure, …)
En plus des personnes et bureaux, l’application doit permettre de gérer du
matériel. Les différents types dans un premier temps sont une ligne
extérieure (05.56….) et un poste interne (1092), mais cela peut évoluer. Un
poste n’est pas lié à une ligne extérieure, un service informatique externe se
charge de répartir à son bon vouloir l’un et/ou l’autre matériel.
## Affectation du matériel à une personne ou à un bureau (ex. un bureau
présent dans une salle de réunion)
L’application doit pouvoir permettre d’affecter un matériel à une personne
ou à un bureau sans collaborateur (ex. un bureau dans une salle de réunion).
Lorsqu’un collaborateur change de bureau, il peut amener avec lui son poste
interne, sa ligne, … ou les laisser sur le bureau.
## Prévision d’occupation avec l’évolution prévisionnelle de l’effectif
Une société a des objectifs d’évolution de l’effectif dans le temps.
Potentiellement +60 dans l’année avec une croissance de 5 collaborateurs
par mois, comment remonter une alerte via l’application sur le fait que les
bureaux seront tous occupés dans 8 mois ?
## Lecture seule pour tous / Administration pour un panel d’utilisateurs
Par défaut, l’application est accessible en lecture seule. Seul un panel
d’utilisateurs peut administrer l’application.
Dans la base de données, les tables collaborateurs et administrateurs
peuvent être distinctes et sans lien. Les 3-4 administrateurs peuvent être 
dans une table distincte avec juste un identifiant et un mot de passe sous
forme de hash.
## Statistiques sur l’occupation des bureaux et du matériel
L’application doit pouvoir afficher des statistiques sur les collaborateurs,
l’utilisation du matériel, des bureaux, de la place disponible restante.
Exemple à prendre en compte, une salle de réunion est composée de
bureaux, pour autant, il ne faut pas considérer cela comme de la place
disponible. (ou alors en mode dégradé ?)
## Upload de plans
Les plans sont des documents chargés par les administrateurs. Le format est
de type image (PNG, JPG).
## Gestion des versions des plans
Plusieurs administrateurs sont en charge de l’application. Certains
administrateurs sont responsables d’un plan ou d’une partie de plan.
Comment gérer différentes versions et consolider ces versions ?
Architecture
Application web desktop
Versionnée (SCM au choix) dès le 1er jour
BDD : au choix
Back : Java / Hibernate / Spring / JUnit, à minima
Couche REST
Front : au choix
Critères CESI d’évaluation
Ce projet peut se réaliser par petits groupes de travail. Ces derniers devront créer
une application en Java. Le langage et la base de données ou le moteur de base de
données est laissé au choix du groupe de travail. Mais ils devront justifier et
argumenter leur choix.
L’accès au repository projet doit être possible à l’issue de la première journée,
afin de pouvoir parcourir les sources et identifier les contributions de chacun.
A l’issue de la période du projet, les participants devront présenter leur travail à
l’oral l’après-midi, en visio, à l’aide d’un support comportant :
▪ Les objectifs détaillés et le backlog
▪ La grille de choix des outils/framework sélectionnés et leur utilité
▪ Une vue de la base de données.
▪ Les hypothèses de travail avec les outils de gestion et pilotage du projet
▪ Une démonstration
▪ Des extraits du code source commenté
▪ La conclusion montrant les possibilités d'extension du projet, ses atouts
(originalité), ses défauts et ses limites hypothétiques
Format de la soutenance : 20 minutes d’exposé, 5 minutes de questions
15h30 : groupe 1,
16h : groupe 2,
16h30 : groupe 3,
17h : groupe 4,
17h30 : groupe 5