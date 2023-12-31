(ns clojure-db-interface-app.interface)

;; (defprotocol DatabaseOperations
;;   (create-table [db])
;;   (insert-data [db name])
;;   (query-data [db]) 
;;   )

(defprotocol DatabaseOperations
  (create-table [db])
  (insert-data [db name])
  (query-data [db])
  (update-data [db id new_name])
  (delete-data [db id]))