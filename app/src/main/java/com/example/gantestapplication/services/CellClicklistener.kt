package com.example.gantestapplication.services

import com.example.gantestapplication.models.BreakingCharacters

interface CellClicklistener {
    fun onCellClickListener(data: BreakingCharacters)
    fun onCellClickListener()
}