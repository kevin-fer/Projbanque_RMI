# Projbanque_RMI
TP 2 RMI de M Buscaldi

# Suppression des .class
rm *.class

# Suppression du BanqueImplement 
rm BanqueImplement_Stub.java

# Donner les droits
chmod 777 * 

# Compiler les fichiers nécéssaires pour le Server
javac Compte.java CompteException.java BanqueInterface.java BanqueImplement.java BanqueServer.java BanqueClient.java

# Indiquer le CLASSPATH
export CLASSPATH=./TP2/src // Mettre le chemin absolu

# Créer automatiquement les stub et skeleton
rmic -keep BanqueImplement

# Lancer le serveur de noms Java
rmiregistry &

# Lancement du serveur 
java -Djava.security.policy=client1.policy BanqueServer

# Compiler les fichiers nécéssaires pour le Client
javac BanqueClient.java Compte.java

# Lancement du client 
java -Djava.security.policy=client1.policy BanqueClient
