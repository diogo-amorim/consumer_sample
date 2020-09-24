# Git variables
GIT_COMMIT ?= $(shell git log -1 --pretty=format:"%H")
GIT_COMMIT_SHORT ?= $(shell git log -1 --pretty=format:"%h")
GIT_BRANCH ?= $(shell git branch | grep '*' | sed 's/* //')
SAFE_GIT_BRANCH ?= $(shell echo $(GIT_BRANCH) | sed 's@/@-@' | tr -s -c '\n\-\+a-z0-9' | tr '[:upper:]' '[:lower:]')
DOMAIN ?= gcd-integration.maersk-digital.net
#Docker variables
IMAGE_NAME = maerskao.azurecr.io/gcd/integration
IMAGE_TAG = 1.0.0_$(GIT_COMMIT_SHORT)


# Maven
maven_build:
	maven -s settings.xml clean install
.PHONY: maven_build

docker_build:
	pwd
	ls -l
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) --build-arg SPRING_PROFILE=$(ENV) . --no-cache
.PHONY: docker_build

docker_push: 
	docker push $(IMAGE_NAME):$(IMAGE_TAG)
.PHONY: docker_push

k8s_deploy:
	kubectl apply -f aks/$(ENV)/app.namespace-$(ENV).yaml || true
	sed "s/_IMAGE_TAG_/${IMAGE_TAG}/" aks/$(ENV)/app.deployment-$(ENV).yaml |  kubectl -n $(K8S_NS) apply -f -
	kubectl -n $(K8S_NS) apply -f aks/$(ENV)/app.ingress-$(ENV).yaml
.PHONY: k8s_deploy
