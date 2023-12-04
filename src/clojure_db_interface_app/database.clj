(ns clojure-db-interface-app.database
  (:require [clojure.java.jdbc :as sql]
            [clojure-db-interface-app.db :as db]
            [clojure-db-interface-app.interface :as iface]))

(defrecord DatabaseImplementation [db-spec]

  iface/DatabaseOperations

  (create-table [_]
                (sql/with-db-connection [db-conn db-spec]
                  (let [tables (sql/query db-conn ["SELECT table_name FROM information_schema.tables WHERE table_name = 'TEST_TABLE'"])]
                    (when (empty? tables)
                      (sql/execute! db-conn ["CREATE TABLE test_table (id SERIAL PRIMARY KEY, name VARCHAR(100))"])))))


  (insert-data [_ name]
    (sql/with-db-connection [db-conn db-spec]
      (sql/insert! db-conn :test_table {:name name})))

  (query-data [_]
    (sql/with-db-connection [db-conn db-spec]
      (sql/query db-conn "SELECT * FROM test_table"))))


