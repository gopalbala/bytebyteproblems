import groovy.json.JsonSlurper
import java.io.File

node {

   // Job properties - keep 5 builds and polls github for changes every 5 mins
// job properties
properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')),
            pipelineTriggers([[$class: "SCMTrigger", scmpoll_spec: "H/5 * * * *"]])])


   stage('Preparation') { // for display purposes

   }

   stage('Build') {
    execGradle "clean build"
   }
   }