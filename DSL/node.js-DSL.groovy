job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/macloujulian/nodejsapp.git', 'master') { node ->
            node / gitConfigName('Usuario DSL')
            node / gitConfigEmail('macloujulian@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('???¿¿¿¿¿¿¿¿¿')
    }
    steps {
        shell("npm install")
    }
    publishers {
		slackNotifier {
            room(alertas)
            notifyAborted(true)
            notifyFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            buildServerUrl(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
        }
    }
}
