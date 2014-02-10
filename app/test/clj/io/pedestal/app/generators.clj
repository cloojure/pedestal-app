; Copyright 2013 Relevance, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns io.pedestal.app.generators
  (:require [simple-check.generators :as gen]))

(defn model [size]
  (if (= size 0)
    (gen/map gen/keyword gen/nat)
    (let [new-size (quot size 2)
          smaller-model (gen/resize new-size (gen/sized model))]
      (gen/map gen/keyword (gen/one-of [gen/nat smaller-model])))))
