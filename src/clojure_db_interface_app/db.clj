(ns clojure-db-interface-app.db

  (:require [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:subprotocol "mysql"
   :subname "//127.0.0.1:3306/TESTDB1"
   :user "root"
   :password "Sathyabama@123"})

;; (def db-spec

;;   {:classname "org.h2.Driver"

;;    :subprotocol "h2:mem"

;;    :subname "test-db"})


