# 1️⃣ On part d'une image officielle Tomcat avec Java déjà installé
FROM tomcat:10.1-jdk17

# 2️⃣ On supprime les applications par défaut (optionnel)
RUN rm -rf /usr/local/tomcat/webapps/*

# 3️⃣ On copie ton fichier WAR dans le dossier de déploiement de Tomcat
COPY ./dist/monapp.war /usr/local/tomcat/webapps/ROOT.war

# 4️⃣ On indique le port sur lequel ton app tourne
EXPOSE 8080

# 5️⃣ On lance le serveur Tomcat quand le conteneur démarre
CMD ["catalina.sh", "run"]