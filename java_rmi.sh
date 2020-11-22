#!/bin/bash

#Suppression des .class
rm *.class

#Suppression du BanqueImplement 
rm BanqueImplement_Stub.java

#Donner les droits
chmod 777 * 

#Compiler les fichiers nécéssaires pour le Server
javac Compte.java CompteException.java BanqueInterface.java BanqueImplement.java BanqueServer.java BanqueClient.java

#Indiquer le CLASSPATH
export CLASSPATH=/home/kevin/FERREIRA_TP1/TP2_projbanquermi_Bonus_TP1/src

# Créer automatiquement les stub et skeleton
rmic -keep BanqueImplement

#Lancer le serveur de noms Java
rmiregistry &

#Lancement du serveur 
java -Djava.security.policy=client1.policy BanqueServer

#Compiler les fichiers nécéssaires pour le Client
javac BanqueClient.java Compte.java

#Lancement du client 
java -Djava.security.policy=client1.policy BanqueClient