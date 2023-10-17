package com.myprojects.pokidexiapp.core.utils

inline fun <T, R> List<T>?.isListNotNullOrEmpty(block: (List<T>) -> R) {
  if (!this.isNullOrEmpty()) {
    block(this)
  }
}

inline fun <T, R> List<T>?.isListNotNullOrEmpty(block: (List<T>) -> R, elseBlock: () -> R) {
  if (this?.isEmpty() == false) {
    block(this)
  } else {
    elseBlock()
  }
}