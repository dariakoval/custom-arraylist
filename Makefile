clean:
	@./gradlew clean

build:
	@./gradlew clean build

doc:
	@./gradlew myJavadocs

test:
	@./gradlew test

report:
	@./gradlew jacocoTestReport

lint:
	@./gradlew checkstyleMain checkstyleTest

update-deps:
	@./gradlew useLatestVersions

.PHONY: build