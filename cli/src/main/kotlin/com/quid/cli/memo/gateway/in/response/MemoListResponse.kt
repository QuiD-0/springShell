package com.quid.cli.memo.gateway.`in`.response

import com.quid.cli.memo.domain.Memo

data class MemoListResponse(
    val memoList: List<Memo>
){
  fun message() = memoList.joinToString("\n") { "#${it.id} - ${String.format(it.description, 10)} - ${it.author}(${it.regDate.toLocalDate()})" }
}