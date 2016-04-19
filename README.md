# izyChamp-y

# ----------- class main -----------  
# liste des villes (vector). 
# boucle qui génère n championnat
# 	=> championnat général qui va générer les championnats
#     /-> parcours la liste des villes et dispatch les villes dans deux poules dans un nouveau championnat
# à ce stade : on a n championnat.
#  - on tri les n championnat en fonction du score eval.
#  - boucle génération do while cond ...
#		cross && mutation
#  return le best championnat (1er du tableau)
#
#
# ----------- class championnat ----------- 
# - deux classes poules
# - score eval championnat : différence entre les scores de ces deux poules 
# - génération aléatoire (villes) ?
#             \-> fonction random
# - génération (poule1, poule2): 
# - fonction cross (championnat)
#		 - boucle sur n championnat, on en choisi 2 au pif, cross pour gosse, cut moitié pas bonne et go
# - fonction mutation()
#
#
# ----------- class poule ----------- 
#		- vector de villes.
# 		- score : formule matheuse (max).
#		fonction getscore
#
#
# ----------- class ville  ----------- 
#   - matrice de distance des villes en static
#   - id de la ligne de la ville en dynamique
#	- classement de la ville
#	- fonction pour calculer la distance entre deux villes  
# 