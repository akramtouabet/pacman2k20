# pacman2k20

Le projet consiste en la r´ealisation d’un jeu s’inspirant du jeu Pacman https://fr.wikipedia.org/wiki/
Pac-Man.
Plus pr´ecis´ement, la partie se d´eroule sur une grille 2D de cases correspondant `a un labyrinthe vu de dessus. Le
jeu consiste `a d´eplacer Pacman, un personnage dans un labyrinthe afin de lui faire manger toutes les pacgommes
qui s’y trouvent. Quatre fantˆomes hantent le labyrinthe et s’y d´eplacent al´eatoirement. Si un des fantˆomes touche le
pacman alors le pacman perd une des ses trois vies. En plus des pacgommes classique (bleus), il existe aussi quatre
pacgommes bonus (autre couleurs). Ces bonus ont un effet sur le pacman et/ou les fantˆomes et/ou le labyrinthe.
Le personnage peut emprunter des passages situ´es de chaque cˆot´e de l’´ecran, produisant un effet de wraparound,
le faisant r´eapparaˆıtre de l’autre cˆot´e du labyrinthe. Le tableau suivant indiques les diff´erents points et effet des
pacgommes.

A cela on rajoute les r`egles suivantes : `
— Initialement il a trois vies.
— Si le joueur d´epasse les 5000 points, il obtient une vie suppl´ementaire.
— Chaque fantˆome se d´eplace dans une direction jusqu’`a ce qu’il atteigne un mur, puis choisit une nouvelle
direction al´eatoirement.
— Quand le pacman est invisible et le pacman pourra traverser les fantˆomes sans perdre de vie.
— Quand le pacman est un superpacman, les fantˆomes deviennent vuln´erables. Dans ce cas, ils se d´eplacent
deux fois plus lentement et ils reviennent au centre du labyrinthe si ils sont touch´es par le pacman.
— Le jeu se termine quand il n’y a plus de pacgommes et la partie est gagn´ee ou quand le pacman a perdu
toutes ses vies et la partie est perdue.
