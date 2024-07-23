# Éléments de correction

Dans le cadre de cet exercice, 1 fichier a été ajouté.

Le test `VaccineDaoTest` :

* La méthode `testShouldInsertVaccineIntoDatabaseSuccessfully` couvre le scénario de test d'insertion dans la base de données ;
* La méthode `testShouldUpdateVaccineIntoDatabaseSuccessfully` couvre le scénario de test de mise à jour dans la base de données ;
* La méthode `testShouldDeleteVaccineFromDatabaseSuccessfully` couvre le scénario de test de suppression dans la base de données.1

A noter que la méthode `getAllVaccinesByAnimalId` de l'interface `VaccineDao` n'a pas de test dédié car elle est couverte dans les 3 autres tests.
