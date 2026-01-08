<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Kunden $model */

$this->title = Yii::t('app', 'Create Kunden');
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Kundens'), 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="kunden-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
