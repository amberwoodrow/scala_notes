FROM williamyeh/scala

WORKDIR /app
ADD . /app

RUN /usr/bin/scalac notes.scala
CMD ["/usr/bin/scala", "HelloWorld"]
