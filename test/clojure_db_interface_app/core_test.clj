;; (ns clojure-db-interface-app.core-test
;;   (:require [clojure.test :refer :all]
;;             [clojure-db-interface-app.core :refer :all]))

;; (deftest a-test
;;   (testing "FIXME, I fail."
;;     (is (= 0 1))))


;; (ns clojure-db-interface-app.core-test

;;   (:require [clojure.test :refer :all]

;;             [clojure-db-interface-app.interface :as iface]

;;             [clojure-db-interface-app.database :as db]
;;             ))

;; (deftest test-database-operations

;;   (let [db-impl (defrecord DatabaseImplementation [db-spec])]

;;     (iface/create-table db-impl)

;;     (is (not (empty? (iface/query-data db-impl))))

;;     (iface/insert-data db-impl "Test User")

;;     (is (not (empty? (iface/query-data db-impl))))))

;; ;; Add more tests as needed if required

;; (run-tests)


;; (ns clojure-db-interface-app.core-test
;;   (:require [clojure.test :refer :all]
;;             [clojure-db-interface-app.interface :as iface] 
;;             [clojure-db-interface-app.database :as db]
;;             ))

;; (defrecord DatabaseImplementation [db-spec])

;; (deftest test-database-operations
;;   (let [db-impl (->DatabaseImplementation db/db-spec)]
;;     (iface/create-table db-impl)
;;     (is (not (empty? (iface/query-data db-impl))))
;;     (iface/insert-data db-impl "Test User")
;;     (is (not (empty? (iface/query-data db-impl))))))

;; (run-tests)


(ns clojure-db-interface-app.core-test
  (:require [clojure.test :refer :all]
            [clojure-db-interface-app.database :as db]
            [clojure-db-interface-app.interface :as iface]))

(def db-spec-mock
   {:subprotocol "mysql"
   :subname "//127.0.0.1:3306/TESTDB1"
   :user "root"
   :password "Sathyabama@123"})

(def db-test (db/->DatabaseImplementation db-spec-mock))

(deftest test-create-table
  (testing "CREATE TABLE"
    (iface/create-table db-test) 
    ))

(deftest test-insert-data
  (testing "INSERT DATA"
    (iface/insert-data db-test "John Doe")
    ))

(deftest test-query-data
  (testing "QUERY DATA"
    (let [data-from-db (iface/query-data db-test)] 
      )))










