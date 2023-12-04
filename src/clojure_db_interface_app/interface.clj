(ns clojure-db-interface-app.interface)

(defprotocol DatabaseOperations
  (create-table [db])
  (insert-data [db name])
  (query-data [db]))