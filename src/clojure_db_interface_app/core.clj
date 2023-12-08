;; (ns clojure-db-interface-app.core
;;   (:gen-class))

;; (defn -main
;;   "I don't do a whole lot ... yet."
;;   [& args]
;;   (println "Hello, World!"))

(ns clojure-db-interface-app.core
  (:require [clojure-db-interface-app.interface :as iface]
            [clojure-db-interface-app.database :as db]
            [clojure-db-interface-app.db :as db-spec]))

(defn -main [& args]
  ;; Initialize the database and create the table
  (let [db-impl (db/->DatabaseImplementation db-spec/db-spec)]
    (iface/create-table db-impl)

    ;; Insert data into the table
    (iface/insert-data db-impl "John Doe")
    (iface/insert-data db-impl "Jane Doe")

    (iface/update-data db-impl 62 "John Smith")
    (iface/delete-data db-impl 59)

    ;; Query and print data
    (let [data (iface/query-data db-impl)]
      (doseq [row data]
        (println (str "ID: " (:id row) ", Name: " (:name row)))))))
