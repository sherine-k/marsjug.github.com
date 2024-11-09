---
title: "Dimensionner des applications pour Kubernetes"
layout: reunion
speakers:
  - rverchere
inscription: https://www.meetup.com/marseille-java-user-group-meetup/events/298525791
location: tricentis
date: 2024-01-23 19:00:00 +0100
---
Lorsqu'on doit déployer une application sur un cluster Kubernetes, une bonne pratique est de définir des ressources "requests" et "limits" pour garantir le bon fonctionnement de celle-ci tout en garantissant la bonne santé du cluster qui l'accueille.

OK, mais quelles valeurs de "requests" et "limits" doit-on spécifier ? Pas assez de RAM et l'application sera "OOMKilled" ? Trop de CPU, mais cela bloquera les autres déploiements ?

Après un rapide rappel des concepts et tour d'horizon des différentes options pour paramétrer ces ressources, je vous présenterai deux outils simples mais efficaces pour vous aider à définir des valeurs pragmatiques : Krr d'une part, Goldilocks et l'utilisation automatique des Vertical Pod Autoscaler d'autre part. Je vous montrerai enfin comment intégrer au mieux ces informations dans vos tableaux de bord.

Pour chaque outil, une démonstration sera faite sur des applications "live", avec mes propres avis et retour d'expérience.

