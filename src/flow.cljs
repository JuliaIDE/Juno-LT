(ns lt.plugins.flow
  (:require [lt.util.dom :as dom]
            [lt.object :as object]
            [crate.core :as crate])
  (:require-macros [lt.macros :refer [behavior defui]]))

(behavior ::animate-on-show
          :triggers #{:object.instant}
          :reaction (fn [this]
                      (let [content (object/->content this)]
                        (-> (js/$ content)
                            (.hide)
                            (.show 200)))))
