def TEST_CASE_VARIABLE

import groovy.json.JsonSlurper

pipeline {
  agent any
  stages {
    stage("Package") {
      when {
        branch 'package'
      }
      steps {
        sh 'mvn clean package'
      }
    }

    stage(TCs) {
      when {
        branch 'master'
      }
      options {
        timeout(time: 60, unit: 'SECONDS')
      }
      input {
        message "Ingresar Test Case"
        ok "Next"
        parameters {
            string(name: 'TCs', defaultValue: '@prueba', description: 'Ingresa aca:')
        }
      }
      steps {
        echo "Hello, ${TCs}, nice to meet you."
        script {
          TEST_CASE_VARIABLE = "${TCs}"
        }
      }
    }
    stage(Test) {
      when {
        branch 'master'
      }
      steps {
        echo "Hello, ${TEST_CASE_VARIABLE}, nice to meet you again."
        script {
          if("${TEST_CASE_VARIABLE}".trim().toUpperCase() == 'all'.toUpperCase()) {
            sh "mvn clean verify"
          } else {
            sh "mvn clean verify -Dcucumber.filter.tags=\" '${TEST_CASE_VARIABLE}' \""
          }
        }
      }
    }
  }
}