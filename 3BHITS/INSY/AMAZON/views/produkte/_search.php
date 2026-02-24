<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/** @var yii\web\View $this */
/** @var app\models\ProdukteSearch $model */
/** @var yii\widgets\ActiveForm $form */
?>

<div class="produkte-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
        'options' => [
            'data-pjax' => 1
        ],
    ]); ?>

    <?= $form->field($model, 'ProduktID') ?>

    <?= $form->field($model, 'Produktname') ?>

    <?= $form->field($model, 'Produktkategorie') ?>

    <?= $form->field($model, 'Stueckpreis') ?>

    <?= $form->field($model, 'LieferantenID') ?>

    <div class="form-group">
        <?= Html::submitButton(Yii::t('app', 'Search'), ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton(Yii::t('app', 'Reset'), ['class' => 'btn btn-outline-secondary']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
